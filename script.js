// Ambil elemen select untuk topik seminar
const topikSelect = document.getElementById('topik');
const message = document.getElementById('message');
const form = document.getElementById('seminarForm');

// Fungsi: Load daftar topik seminar dari backend
fetch('/api/topik')
  .then(response => {
    if (!response.ok) throw new Error('Gagal mengambil daftar topik');
    return response.json();
  })
  .then(data => {
    data.forEach(topik => {
      const option = document.createElement('option');
      option.value = topik.id;
      option.textContent = topik.nama;
      topikSelect.appendChild(option);
    });
  })
  .catch(err => {
    console.error('Error:', err);
    message.textContent = 'Gagal memuat daftar topik seminar.';
  });

// Fungsi: Validasi email sederhana
function isValidEmail(email) {
  const regex = /^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$/;
  return regex.test(email);
}

// Fungsi: Saat form disubmit
form.addEventListener('submit', function(e) {
  e.preventDefault();

  // Ambil data dari form
  const nama = document.getElementById('nama').value.trim();
  const email = document.getElementById('email').value.trim();
  const instansi = document.getElementById('instansi').value.trim();
  const topikId = document.getElementById('topik').value;
  const pembayaran = document.querySelector('input[name="pembayaran"]:checked');

  // Validasi
  if (!nama || !email || !topikId || !pembayaran) {
    message.textContent = 'Semua field wajib diisi.';
    return;
  }

  if (!isValidEmail(email)) {
    message.textContent = 'Format email tidak valid.';
    return;
  }

  // Siapkan data yang akan dikirim
  const data = {
    nama: nama,
    email: email,
    instansi: instansi,
    topikId: topikId,
    metodePembayaran: pembayaran.value
  };

  // Kirim data ke backend
  fetch('/api/pendaftaran', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data)
  })
  .then(res => {
    if (!res.ok) throw new Error('Gagal mendaftar');
    return res.json();
  })
  .then(result => {
    message.textContent = 'Pendaftaran berhasil!';
    form.reset();
  })
  .catch(error => {
    console.error('Error:', error);
    message.textContent = 'Terjadi kesalahan saat mendaftar.';
  });
});
