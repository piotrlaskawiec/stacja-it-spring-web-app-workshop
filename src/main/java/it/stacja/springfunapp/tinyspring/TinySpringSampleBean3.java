package it.stacja.springfunapp.tinyspring;

@Element
@Lazy
@Proto
public class TinySpringSampleBean3 {
    public TinySpringSampleBean3() {
        System.out.println("Constructor TinySpringSampleBean3");
    }

    @WhenCreated
    public void init() {
        System.out.println("After constructor");
    }
}
