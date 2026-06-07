package com.salomovs.ninjacouncil.docs;

import com.salomovs.ninjacouncil.dto.NinjaRequest;
import com.salomovs.ninjacouncil.dto.NinjaResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Ninja's Operations")
public interface INinjaController {

  @Operation(summary="Performs a ninja's registration")
  NinjaResponse ninjaRegistry(
    @RequestBody(content=@Content(schema=@Schema(implementation=NinjaRequest.class, example="{}")))
    NinjaRequest req
  );

}
