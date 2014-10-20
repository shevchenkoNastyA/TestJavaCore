/**
 * Created by Nastya on 12.10.2014.
 */
class WithInner {
    class Inner {}
}
public class InheritInner extends WithInner.Inner {
    //! InheritInner() {} // Won’t compile
    public InheritInner(WithInner wi) {
        wi.super();
    }

}
////tested in main