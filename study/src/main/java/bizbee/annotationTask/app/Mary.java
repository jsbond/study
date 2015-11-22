package bizbee.annotationTask.app;

import bizbee.annotationTask.framework.Wife;

/**
 *
 */
@Wife
public class Mary implements Man {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
