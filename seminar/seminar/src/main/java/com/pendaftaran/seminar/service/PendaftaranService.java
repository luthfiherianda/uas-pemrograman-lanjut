@Service
public class PendaftaranService {

    private final PendaftaranRepository repo;

    public PendaftaranService(PendaftaranRepository repo) {
        this.repo = repo;
    }

    public Pendaftaran simpan(Pendaftaran pendaftaran) {
        return repo.save(pendaftaran);
    }
}
