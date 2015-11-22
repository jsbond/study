package bizbee.annotationTask.framework;

import bizbee.annotationTask.app.Man;

/**
 *
 */
public class Bob implements Man {
    private String name;

    public void tellSeeStory(Man man, Exception e) {

        if (man.getClass().isAnnotationPresent(Friend.class)) {
            Friend annotation = man.getClass().getAnnotation(Friend.class);
            final String name = annotation.name();
            System.out.println(name + ", " + e.getMessage());
        }else
        if (man.getClass().isAnnotationPresent(Wife.class)) {
            Friend annotation = man.getClass().getAnnotation(Friend.class);
            System.out.println("Dear, the weather is beautiful");
        }else {
            System.out.println("Hello, what is your name?");
        }


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
