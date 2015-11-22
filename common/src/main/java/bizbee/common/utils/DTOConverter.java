package bizbee.common.utils;

/**
 *
 */
public class DTOConverter {

    public DTOConverter() {
    }

    public void convert(Object object) {
        Class<?> clazz = object.getClass();
        DTO anno = clazz.getAnnotation(DTO.class);
        System.out.println(anno.entity());
    }

}
