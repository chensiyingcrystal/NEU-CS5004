

public class Shape {
    public Area area;

    public Area getArea() {
        return area;
    }

//    @Override
//    public int compareTo(Shape o){
//        if (o == null) {
//            throw new NullPointerException("NUll shape");
//        }
//
//        if (!(o instanceof Shape)) {
//            throw new IllegalArgumentException("Not same class");
//        }
//
//        if (o == this) return 0;
//
//        if(this.getArea() > o.getArea()) {
//            return 1;
//        }
//        else if (this.getArea() < o.getArea()) {
//            return -1;
//        }
//        else {
//            return 0;
//        }
//    }




}
