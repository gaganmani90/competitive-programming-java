package design.usersession.transformers;

public interface Transformer<S, T> {
    T transform(S source);
}
