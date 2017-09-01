package it.stacja.springfunapp.tinyspring;

@Element
public class TinySpringSampleBean2 {
    private final TinySpringSampleBean1 tinySpringSampleBean1;

    public TinySpringSampleBean2(TinySpringSampleBean1 tinySpringSampleBean1) {
        this.tinySpringSampleBean1 = tinySpringSampleBean1;
    }

    public void businessMethod() {
        System.out.println("TinySpringSampleBean2 businessMethod");
        this.tinySpringSampleBean1.businessMethod();
    }
}
