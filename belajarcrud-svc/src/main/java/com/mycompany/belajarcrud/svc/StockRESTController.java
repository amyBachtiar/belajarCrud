package com.mycompany.belajarcrud.svc;

/**
 *
 * @author amy
 */
import com.mycompany.belajarcrud.domain.Stock;
import com.mycompany.belajarcrud.domain.assembler.StockAssembler;
import com.mycompany.belajarcrud.domain.repository.PartRepository;
import com.mycompany.belajarcrud.domain.repository.StockRepository;
import com.mycompany.belajarcrud.dto.StockDTO;
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
public class StockRESTController {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    PartRepository partRepository;

    @RequestMapping(value = "/get.stock.dummy",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> getStockDummy() {
        return ResponseEntity.status(HttpStatus.FOUND).body(new StockDTO().getInstance());
    }

    @RequestMapping(value = "/get.stock.by.code/{code}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> getStockByCode(@PathVariable("code") String code) {
        Stock data = stockRepository.findOneByCode(code);
        if (data == null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(new StockAssembler().toDTO(data));
    }

    @RequestMapping(value = "/post.stock",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> postStock(@RequestBody StockDTO stockDTO) {
        Stock stock = new StockAssembler().toDomain(stockDTO);
        stock.setPart(partRepository.findOneByCode(stockDTO.getPartCode()));
        stockRepository.save(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(stockDTO);
    }

    @RequestMapping(value = "/update.stock",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> updateStock(@RequestBody StockDTO stockDTO) {
        Stock stock = stockRepository.findOneByCode(stockDTO.getCode());
        stock.setPart(partRepository.findOneByCode(stockDTO.getPartCode()));
        stock.setQuantity(Integer.SIZE);
        stock.setStatus(true);
        stockRepository.save(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(new StockAssembler().toDTO(stock));
    }

    @RequestMapping(value = "/delete.stock/{code}",
            method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStock(@PathVariable("code") String code) {
        Stock stock = (Stock) stockRepository.findOneByCode(code);
        stockRepository.delete(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body("Stock : " + stock.getCode()+ " is Successfully deleted");
    }
}
