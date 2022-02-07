package design.transaction;

class RuleProperty<T> {
    String name;
    T value;
    String operator;

    public RuleProperty(String name, T value, String operator) {
        this.name = name;
        this.value = value;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "RuleProperty{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", operator='" + operator + '\'' +
                '}';
    }

    public boolean apply(T actualValue) {
        if (actualValue instanceof Long) {
            return applyLong((Long) actualValue);
        } else {
            return applyString((String) actualValue);
        }
    }

    private boolean applyString(String actualValue) {
        boolean isValid = false;
        String valueStr = (String) this.value;
        switch (this.operator) {
            case "==":
                isValid = valueStr.equals(actualValue);
                break;
            case "!=":
                isValid = !valueStr.equals(actualValue);
                break;
        }
        return isValid;
    }

    private boolean applyLong(Long actualValue) {
        boolean isValid = false;
        switch (this.operator) {
            case ">":
                isValid = actualValue.longValue() > (Long) (this.value);
                break;
            case "<":
                isValid = actualValue.longValue() < (Long) (this.value);
                break;
            case ">=":
                isValid = actualValue.longValue() >= (Long) (this.value);
                break;
            case "<=":
                isValid = actualValue.longValue() <= (Long) (this.value);
                break;
            case "==":
                isValid = actualValue.longValue() == (Long) (this.value);
                break;
            case "!=":
                isValid = actualValue.longValue() != (Long) (this.value);
                break;

        }
        return isValid;
    }
}
