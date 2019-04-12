package com.mycompany.belajarcrud.svc;

/**
 *
 * @author amy
 */
import com.mycompany.belajarcrud.domain.Bizpar;
import com.mycompany.belajarcrud.domain.assembler.BizparAssembler;
import com.mycompany.belajarcrud.domain.repository.BizparRepository;
import com.mycompany.belajarcrud.dto.BizparDTO;
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
public class BizparRESTController {

    @Autowired
    BizparRepository bizparRepository;

    @RequestMapping(value = "/get.bizpar.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BizparDTO> getBizparDummy() {
        return ResponseEntity.status(HttpStatus.FOUND).body(new BizparDTO().getInstance());
    }

    @RequestMapping(value = "/get.bizpar.by.key/{key}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BizparDTO> getBizparByKey(@PathVariable("key") String key) {
        Bizpar data = bizparRepository.findOneByKey(key);
        if (data == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new BizparAssembler().toDTO(data));
    }

    @RequestMapping(value = "/post.bizpar",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BizparDTO> postBizpar(@RequestBody BizparDTO bizparDTO) {
        bizparRepository.save(new BizparAssembler().toDomain(bizparDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(bizparDTO);
    }

    @RequestMapping(value = "/update.bizpar",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BizparDTO> updateBizpar(@RequestBody BizparDTO bizparDTO) {
        Bizpar bizpar = (Bizpar) bizparRepository.findOneByKey(bizparDTO.getKey());
        bizpar.setValue(bizparDTO.getValue());
        bizpar.setStatus(bizparDTO.getStatus());
        bizparRepository.save(bizpar);
        return ResponseEntity.status(HttpStatus.CREATED).body(new BizparAssembler().toDTO(bizpar));
    }

    @RequestMapping(value = "/delete.bizpar/{key}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBizpar(@PathVariable("key") String key) {
        Bizpar bizpar = (Bizpar) bizparRepository.findOneByKey(key);
        bizparRepository.delete(bizpar);
        return ResponseEntity.status(HttpStatus.CREATED).body("Bizpar : " + bizpar.getKey() + " is Successfully deleted");
    }
    //asem nyawi nyawi2 nyawilagi
}
