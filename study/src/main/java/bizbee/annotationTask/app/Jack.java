package bizbee.annotationTask.app;

import bizbee.annotationTask.framework.Friend;

/**
 *
 */
@Friend(name = "Jack")
public class Jack implements Man {

    private String name = "Jack";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
