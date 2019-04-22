package com.mycompany.belajarcrud.svc;

/**
 * 
 * @author tikaa
 */
import com.mycompany.belajarcrud.domain.Mutation;
import com.mycompany.belajarcrud.domain.assembler.MutationAssembler;
import com.mycompany.belajarcrud.domain.repository.MutationRepository;
import com.mycompany.belajarcrud.dto.MutationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MutationRESTController {
    @Autowired
    MutationRepository mutationRepository;
    
    @RequestMapping(value = "/get.mutation.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MutationDTO> getMutationDummy(){
        return ResponseEntity.status(HttpStatus.FOUND).body(new MutationDTO().getInstance());
    }
    
    @RequestMapping(value = "/get.mutation.by.mutationNumber/{mutationNumber}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MutationDTO> getMutationByMutationNumber(@PathVariable("mutationNumber") String mutationNumber){
        Mutation data = mutationRepository.findOneByMutationNumber(mutationNumber);
        if(data == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new MutationAssembler().toDTO(data));
    }
    
    @RequestMapping(value = "/post.mutation",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MutationDTO> postMutation(@RequestBody MutationDTO mutationDTO) {
        mutationRepository.save(new MutationAssembler().toDomain(mutationDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(mutationDTO);
    }
    
    @RequestMapping(value = "/update.mutation",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MutationDTO> updateMutation(@RequestBody MutationDTO mutationDTO) {
        Mutation mutation = (Mutation) mutationRepository.findOneByMutationNumber(mutationDTO.getMutationNumber());
        mutation.setEmpID(mutationDTO.getEmpID());
        mutation.setEmpName(mutationDTO.getEmpName());
        mutation.setPosition(mutationDTO.getPosition());
        mutation.setFinalPosition(mutationDTO.getFinalPosition());
        mutation.setMutated(mutationDTO.isMutated());
        mutation.setMutationNumber(mutationDTO.getMutationNumber());
        mutation.setMutationDate(mutationDTO.getMutationDate());
        //mutation.setMutationBatch(mutationDTO.getMutationBatch());
        mutationRepository.save(mutation);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MutationAssembler().toDTO(mutation));
    }
    
    @RequestMapping (value = "/delete.mutation/{mutationNumber}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteMutation(@PathVariable("mutationNumber") String mutationNumber) {
        Mutation mutation = (Mutation) mutationRepository.findOneByMutationNumber(mutationNumber);
        mutationRepository.delete(mutation);
        return ResponseEntity.status(HttpStatus.CREATED).body("Mutation : " + mutation.getMutationNumber()+ " is Successfully deleted");
    }
}
