package com.unmsm.matchjobs.notifications.Common;

import java.util.ArrayList;
import java.util.List;

public final class Envelope {
    private final Object result;
    private final List<Error> errors;

    private Envelope(Object result, List<Error> errors) {
        this.result = result;
        this.errors = errors;
    }

    public static Envelope ok(Object result) {
        return new Envelope(result, new ArrayList());
    }

    public static Envelope error(List<Error> errors) {
        if (errors == null) {
            errors = new ArrayList();
        }

        return new Envelope((Object)null, (List)errors);
    }

    public static Envelope serverError() {
        List<Error> errors = new ArrayList();
        Error error = new Error("Internal Server Error", (Exception)null);
        errors.add(error);
        return new Envelope((Object)null, errors);
    }

    public static Envelope notFound() {
        List<Error> errors = new ArrayList();
        Error error = new Error("entity not found", (Exception)null);
        errors.add(error);
        return new Envelope((Object)null, errors);
    }

    public Object getResult() {
        return this.result;
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Envelope)) {
            return false;
        } else {
            Envelope other = (Envelope)o;
            Object this$result = this.getResult();
            Object other$result = other.getResult();
            if (this$result == null) {
                if (other$result != null) {
                    return false;
                }
            } else if (!this$result.equals(other$result)) {
                return false;
            }

            Object this$errors = this.getErrors();
            Object other$errors = other.getErrors();
            if (this$errors == null) {
                if (other$errors != null) {
                    return false;
                }
            } else if (!this$errors.equals(other$errors)) {
                return false;
            }

            return true;
        }
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $result = this.getResult();
        result = result * 59 + ($result == null ? 43 : $result.hashCode());
        Object $errors = this.getErrors();
        result = result * 59 + ($errors == null ? 43 : $errors.hashCode());
        return result;
    }

    public String toString() {
        Object var10000 = this.getResult();
        return "Envelope(result=" + var10000 + ", errors=" + this.getErrors() + ")";
    }
}
