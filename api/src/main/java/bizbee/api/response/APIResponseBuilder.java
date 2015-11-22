package bizbee.api.response;

/**
 *
 */

import java.io.Serializable;
import java.util.Collection;

public final class APIResponseBuilder {

    private APIResponseBuilder() {

    }

    public static <T extends Serializable> APIResponse<T> build(Collection<T> elements, int offset, int limit, int totalElements) {
        final APIResponse<T> apiResponse = build(elements);
        final Meta meta = new Meta();
        meta.setOffset(offset);
        meta.setLimit(limit);
        int totalPages = limit == 0 ? 0 : (int) Math.ceil((double) totalElements / (double) limit);
        meta.setTotalPages(totalPages);
        meta.setTotalElements(totalElements);
        apiResponse.setMeta(meta);
        return apiResponse;
    }

    public static <T extends Serializable> APIResponse<T> build(Collection<T> elements) {
        final APIResponse<T> apiResponse = new APIResponse<T>();
        apiResponse.addElements(elements);
        return apiResponse;
    }

    public static <T extends Serializable> APIResponse<T> build(T element) {
        final APIResponse<T> apiResponse = new APIResponse<T>();
        apiResponse.addElement(element);
        return apiResponse;
    }
}
