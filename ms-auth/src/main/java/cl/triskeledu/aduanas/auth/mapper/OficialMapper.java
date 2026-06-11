package cl.triskeledu.aduanas.auth.mapper;

import cl.triskeledu.aduanas.auth.dto.OficialRequest;
import cl.triskeledu.aduanas.auth.dto.OficialResponse;
import cl.triskeledu.aduanas.auth.model.Oficial;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface OficialMapper {

    OficialResponse toResponse(Oficial oficial);

    List<OficialResponse> toResponseList(List<Oficial> oficiales);

    @Mapping(target = "id", ignore = true)
    Oficial toEntity(OficialRequest request);

    @Mapping(target = "id", ignore = true)
    void updateEntity(OficialRequest request, @MappingTarget Oficial oficial);
}
