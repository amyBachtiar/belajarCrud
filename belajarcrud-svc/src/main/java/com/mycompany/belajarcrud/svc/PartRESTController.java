package com.mycompany.belajarcrud.svc;

/**
 *
 * @author amy
 */
import com.mycompany.belajarcrud.domain.Part;
import com.mycompany.belajarcrud.domain.Stock;
import com.mycompany.belajarcrud.domain.assembler.PartAssembler;
import com.mycompany.belajarcrud.domain.repository.PartRepository;
import com.mycompany.belajarcrud.domain.repository.StockRepository;
import com.mycompany.belajarcrud.dto.PartDTO;
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

/**
 *
 * @author amy
 */
@RestController
@Slf4j
public class PartRESTController {

    @Autowired
    PartRepository partRepository;
    
    @Autowired
    StockRepository stockRepository;

    @RequestMapping(value = "/get.part.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartDTO> getPartDummy() {
        return ResponseEntity.status(HttpStatus.FOUND).body(new PartDTO().getInstance());
    }

    @RequestMapping(value = "/get.part.by.code/{code}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartDTO> getPartBycode(@PathVariable("code") String code) {
        Part data = partRepository.findOneByCode(code);
        if (data == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new PartAssembler().toDTO(data));
    }

    @RequestMapping(value = "/post.part",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartDTO> postPart(@RequestBody PartDTO partDTO) {
        partRepository.save(new PartAssembler().toDomain(partDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(partDTO);
    }

    @RequestMapping(value = "/update.part",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PartDTO> updateBizpar(@RequestBody PartDTO partDTO) {
        Part part = (Part) partRepository.findOneByCode(partDTO.getCode());
        part.setDescription(partDTO.getDescription());
        part.setStatus(true);
        partRepository.save(part);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PartAssembler().toDTO(part));
    }

    @RequestMapping(value = "/delete.part/{code}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBizpar(@PathVariable("code") String code) {
        Part part = (Part) partRepository.findOneByCode(code);
        partRepository.delete(part);
        return ResponseEntity.status(HttpStatus.CREATED).body("Part : " + part.getCode()+ " is Successfully deleted");
    }
}
