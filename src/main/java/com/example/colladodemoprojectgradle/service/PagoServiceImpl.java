package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Pago;
//import com.example.vuelos.repository.PagoRepository;
import com.example.colladodemoprojectgradle.model.Pago;
import com.example.colladodemoprojectgradle.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PagoServiceImpl extends BaseServiceImpl<Pago, Long> implements PagoService {

    private final PagoRepository pagoRepository;

    @Autowired
    public PagoServiceImpl(PagoRepository pagoRepository) {
        super(pagoRepository);
        this.pagoRepository = pagoRepository;
    }

    @Override
    public Optional<Pago> findByReservaId(Long reservaId) throws Exception {
        try {
            return pagoRepository.findByReservaId(reservaId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}