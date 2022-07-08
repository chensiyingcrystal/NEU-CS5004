package bignumber;

public class BigNumberImpl implements BigNumber {
    private Digit head;

    public BigNumberImpl() {
        this.head = new Digit(0);
    }

    public BigNumberImpl(Digit head) {
        this.head = head;
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
            if (this.head.val == 0) return this;
            Digit last = findLastDigit();
            while (shifts-- > 0) {
                last.next = new Digit(0);
                last = last.next;
            }
        }
        else {
            return shiftRight(-shifts);
        }
        return this;

    }

    @Override
    public BigNumber shiftRight(int shifts) {
        if (shifts == 0) {
            throw new IllegalArgumentException("right shifts cannot be 0!");
        }

        if (shifts > this.length() && this.head.val != 0) {
            throw new IllegalArgumentException("right shifts extend valid shifting times!");
        }

        if (this.head.val == 0 && shifts > 0) {
            return this;
        }

        Digit dummy = new Digit(0);
        dummy.next = head;

        if (shifts > 0) {
            Digit slow = dummy, fast = dummy;
            while (shifts-- > 0) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow == dummy? new Digit(0) : null;
        }
        else {
            return shiftLeft(-shifts);
        }
        return new BigNumberImpl(dummy.next);

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
        int carry = digit, sum = 0;
        Digit temp = this.head, last = this.head;
        while (temp != null) {
            sum = temp.val + carry;
            temp.val = sum % 10;
            carry = sum >= 10? 1 : 0;
            if (carry == 0) break;
            temp = temp.next;
            if (temp != null && temp.next == null) last = temp;
        }

        if (carry != 0) {
            last.next = new Digit(carry);
        }

        //reverse back a "list"
        this.reverseDigit(this.head);
        return this;
    }

    @Override
    public int getDigitAt(int position) {
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
            p2.next = p1.next == null? null : new Digit(0);
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
        other2.reverseDigit(other2.head);

        //initialize sum and carry, continuing add and create digits until traverse through both number's digits
        Digit p1 = this.head, p2 = other2.head;
        int sum, carry = 0;
        BigNumberImpl ans = new BigNumberImpl();
        Digit dummy = new Digit(0), p3 = dummy;
        dummy.next = ans.head;

        while (p1 != null || p2 != null) {
            int v1 = p1 == null? 0 : p1.val;
            int v2 = p2 == null? 0 : p2.val;
            sum = v1 + v2 + carry;
            carry = sum >= 10? 1 : 0;
            p3.next = new Digit(sum % 10);
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
            p3 = p3.next;
        }

        if (carry != 0) p3.next = new Digit(carry);

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
            ans += Integer.toString(temp.val);
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
