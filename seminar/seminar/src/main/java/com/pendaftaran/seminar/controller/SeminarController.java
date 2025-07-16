package com.pendaftaran.seminar.controller;

import com.pendaftaran.seminar.model.Topik;
import com.pendaftaran.seminar.model.Pendaftaran;
import com.pendaftaran.seminar.repository.TopikRepository;
import com.pendaftaran.seminar.repository.PendaftaranRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*") // agar bisa diakses dari frontend yang terpisah
@RestController
@RequestMapping("/api")
public class SeminarController {

    private final TopikRepository topikRepo;
    private final PendaftaranRepository daftarRepo;

    public SeminarController(TopikRepository topikRepo, PendaftaranRepository daftarRepo) {
        this.topikRepo = topikRepo;
        this.daftarRepo = daftarRepo;
    }

    @GetMapping("/topik")
    public List<Topik> getTopik() {
        return topikRepo.findAll();
    }

    @PostMapping("/pendaftaran")
    public ResponseEntity<Pendaftaran> daftar(@RequestBody Map<String, String> data) {
        Pendaftaran p = new Pendaftaran();
        p.setNama(data.get("nama"));
        p.setEmail(data.get("email"));
        p.setInstansi(data.get("instansi"));
        p.setMetodePembayaran(data.get("metodePembayaran"));

        Long topikId = Long.parseLong(data.get("topikId"));
        Optional<Topik> topik = topikRepo.findById(topikId);
        topik.ifPresent(p::setTopik);

        return ResponseEntity.ok(daftarRepo.save(p));
    }
}
