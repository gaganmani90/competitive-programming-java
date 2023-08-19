package design.usersession;

public interface Transformer<S, T> {
    T transform(S source);
}
