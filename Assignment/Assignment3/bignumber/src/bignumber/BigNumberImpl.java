package bignumber;

public class BigNumberImpl implements BigNumber {
    private Digit head;

    public BigNumberImpl() {
        this.head = new Digit('0');
    }

    public BigNumberImpl(Digit head) {
        this.head = head;
    }

    public BigNumberImpl(String s) {
        if (!Character.isDigit(s.charAt(0)) || (s.charAt(0) == '0' && s.length() != 1)) {
            throw new IllegalArgumentException("Not valid number representation!");
        }

        this.head = new Digit(s.charAt(0));
        Digit temp = this.head;

        for (int i = 1; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                throw new IllegalArgumentException("Not valid number representation!");
            }

            temp.next = new Digit(s.charAt(i));
            temp = temp.next;
        }
    }

    @Override
    public int length() {
        int count = 0;
        Digit temp = this.head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private Digit findLastDigit() {
        if (this == null) return null;
        Digit last = head;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    @Override
    public BigNumber shiftLeft(int shifts) {
        if (shifts >= 0) {
            if (this.head.val == '0') return this;
            Digit last = findLastDigit();
            while (shifts-- > 0) {
                last.next = new Digit('0');
                last = last.next;
            }
        }
        else {
            return shiftRight(-1 * shifts);
        }
        return this;

    }

    @Override
    public BigNumber shiftRight(int shifts) {
        if (shifts == 0) {
            return this;
        }

        if (this.head.val == '0' && shifts > 0) {
            return this;
        }

        Digit dummy = new Digit('0');
        dummy.next = head;

        if (shifts > 0) {
            Digit slow = dummy, fast = dummy;
            while (shifts-- > 0 && fast != null) {
                fast = fast.next;
            }
            while (fast != null && fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            if (slow == dummy) {
                this.head = new Digit('0');
            }
            else {
                slow.next = null;
            }

        }
        else {
            return shiftLeft(-1 * shifts);
        }
        return this;

    }

    private Digit reverseDigit(Digit first) {
        if (first == null) return null;
        if (first.next == null) {
            this.head = first;
            return first;
        }
        reverseDigit(first.next).next = first;
        first.next = null;
        return first;
    }

    @Override
    public BigNumber addDigit(int digit) {
        if (this == null) return null;
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException("digit is not valid!");
        }

        //first reverse a "list"
        this.reverseDigit(this.head);

        //add digit to it with a carry, continue adding carry to next digit until there is no carry
        int carry = digit, sum;
        Digit temp = this.head, last = this.head;
        while (temp != null) {
            sum = (temp.val - '0') + carry;
            temp.val = (char)(sum % 10 + '0');
            carry = sum >= 10? 1 : 0;
            if (carry == 0) break;
            temp = temp.next;
            if (temp != null && temp.next == null) last = temp;
        }

        if (carry != 0) {
            last.next = new Digit((char)(carry + '0'));
        }

        //reverse back a "list"
        this.reverseDigit(this.head);
        return this;
    }

    @Override
    public char getDigitAt(int position) {
        if (position < 0 || position >= this.length()) {
            throw new IllegalArgumentException("Invalid position!");
        }

        int count = this.length() - 1;
        Digit temp = this.head;
        while (count > position) {
            count--;
            temp = temp.next;
        }
        return temp.val;
    }

    @Override
    public BigNumber copy() {
        if (this == null) return null;
        BigNumberImpl other = new BigNumberImpl();
        Digit p1 = this.head, p2 = other.head;
        while (p1 != null && p2 != null) {
            p2.val = p1.val;
            p2.next = p1.next == null? null : new Digit('0');
            p1 = p1.next;
            p2 = p2.next;
        }
        return other;
    }

    @Override
    public BigNumber add(BigNumber other) {
        if (this == null || other == null) return null;
        //reverse two numbers
        this.reverseDigit(this.head);
        BigNumberImpl other2 = (BigNumberImpl) other;
        if (other2.head.val == '0') return this;
        other2.reverseDigit(other2.head);

        //initialize sum and carry, continuing add and create digits until traverse through both number's digits
        Digit p1 = this.head, p2 = other2.head;
        int sum, carry = 0;
        BigNumberImpl ans = new BigNumberImpl();
        Digit dummy = new Digit('0'), p3 = dummy;
        dummy.next = ans.head;

        while (p1 != null || p2 != null) {
            int v1 = p1 == null? 0 : p1.val - '0';
            int v2 = p2 == null? 0 : p2.val - '0';
            sum = v1 + v2 + carry;
            carry = sum >= 10? 1 : 0;
            p3.next = new Digit((char)((sum % 10) + '0'));
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
            p3 = p3.next;
        }

        if (carry != 0) p3.next = new Digit((char)(carry + '0'));

        //reverse added number
        ans.reverseDigit(dummy.next);

        return ans;
    }

    @Override
    public int compareTo(BigNumber other) {
        if (this == null && other == null) return 0;
        if (this == null || other == null) {
            throw new IllegalStateException("object cannot be null!");
        }
        if (this == other) return 0;
        if (other.getClass() != BigNumberImpl.class) {
            throw new IllegalArgumentException("other must be an instance of BigNumberImpl class!");
        }

        BigNumberImpl other2 = (BigNumberImpl) other;
        if (this.length() > other2.length()) return 1;
        if (this.length() < other2.length()) return -1;

        Digit p1 = this.head, p2 = other2.head;
        while (p1 != null) {
            if (p1.val > p2.val) return 1;
            if (p1.val < p2.val) return -1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return 0;
    }

    @Override
    public String toString() {
        String ans = "";
        Digit temp = head;
        while (temp != null) {
            ans += Character.toString(temp.val);
            temp = temp.next;
        }
        return ans;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (obj.getClass() != BigNumberImpl.class) return false;

        BigNumberImpl other = (BigNumberImpl) obj;
        if (this.length() != other.length()) return false;

        Digit p1 = this.head, p2 = other.head;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }

}
