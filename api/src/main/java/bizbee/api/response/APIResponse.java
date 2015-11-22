package bizbee.api.response;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public final class APIResponse<T extends Serializable> {

    private final Collection<T> data = new ArrayList<T>();
    private Meta meta;

    public Collection<T> getData() {
        return data;
    }

    public void addElements(Collection<T> elements) {
        if (elements != null) {
            this.data.addAll(elements);
        }
    }

    public void addElement(T element) {
        if (element != null) {
            this.data.add(element);
        }
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}