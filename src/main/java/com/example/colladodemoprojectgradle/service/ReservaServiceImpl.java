package com.example.colladodemoprojectgradle.service;

//package com.example.vuelos.service;
//
//import com.example.vuelos.model.Reserva;
//import com.example.vuelos.repository.ReservaRepository;
import com.example.colladodemoprojectgradle.model.Reserva;
import com.example.colladodemoprojectgradle.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservaServiceImpl extends BaseServiceImpl<Reserva, Long> implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        super(reservaRepository);
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<Reserva> findByUsuarioId(Long usuarioId) throws Exception {
        try {
            return reservaRepository.findByUsuarioId(usuarioId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Reserva> findByVueloId(Long vueloId) throws Exception {
        try {
            return reservaRepository.findByVueloId(vueloId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}