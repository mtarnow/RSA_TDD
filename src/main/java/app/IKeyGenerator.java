package app;

public interface IKeyGenerator<K> {
    K generate();
    /*
    returns:
    0  n [private]
    1  d[private]
    2  n[public]
    3 e[public]

     */
}
