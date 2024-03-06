package com.jack.projectdossier.domain.mappers;

public interface Mapper<A, B>{
    B mapTo(A a);
    A mapFrom(B b);
}
