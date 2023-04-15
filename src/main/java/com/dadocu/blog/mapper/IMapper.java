package com.dadocu.blog.mapper;
public interface IMapper<I, O> {
    O map(I in);
}
