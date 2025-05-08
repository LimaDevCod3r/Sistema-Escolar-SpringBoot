package com.SistemaEscolar.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {

    private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    /**
     * Converte um objeto de origem em uma nova instância do tipo de destino especificado.
     *
     * @param source objeto de origem
     * @param destinationClass classe do tipo de destino
     * @param <O> tipo de origem
     * @param <D> tipo de destino
     * @return objeto convertido para o tipo de destino
     */
    public static <O, D> D mapObject(O source, Class<D> destinationClass) {
        return mapper.map(source, destinationClass);
    }

    /**
     * Converte uma lista de objetos de origem em uma lista de objetos do tipo de destino especificado.
     *
     * @param sourceList lista de objetos de origem
     * @param destinationClass classe do tipo de destino
     * @param <O> tipo de origem
     * @param <D> tipo de destino
     * @return lista de objetos convertidos
     */
    public static <O, D> List<D> mapList(List<O> sourceList, Class<D> destinationClass) {
        List<D> destinationList = new ArrayList<>();
        for (O source : sourceList) {
            destinationList.add(mapper.map(source, destinationClass));
        }
        return destinationList;
    }
}
