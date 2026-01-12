# Test Automation Project - Android Demo App

## Deskripsi

Project ini adalah automation testing untuk aplikasi demo Android menggunakan:

- **Appium** sebagai automation framework untuk mobile.
- **Cucumber** untuk Behavior Driven Development (BDD) dengan feature file.
- **TestNG** sebagai test runner.
- **Page Object Model** untuk struktur kode yang rapi dan maintainable.

---

## Struktur Project

src/
├── test/
│ ├── java/
│ │ ├── base/ # Base class dan setup driver
│ │ ├── hooks/ # Hooks seperti before/after scenario
│ │ ├── locators/ # Locator kelas untuk element UI
│ │ ├── pages/ # Page Object classes
│ │ ├── runners/ # TestNG Cucumber runner class
│ │ ├── stepdefinitions/ # Step Definition class untuk feature files
│ │ └── utils/ # Utility class (misal DriverFactory)
│ └── resources/
│ └── features/ # Feature files (.feature)
└── target/ # Output hasil build dan report


---

## Persiapan Environment

- Java 11+
- Android Emulator atau device nyata yang sudah aktif dan terkoneksi
- Appium Server terbaru dan running
- Maven untuk dependency management dan build

---

## Cara Menjalankan Test

1. Jalankan Appium Server (GUI atau CLI).
2. Pastikan emulator/device sudah online.
3. Jalankan class `TestRunner` sebagai TestNG test di IDE (IntelliJ IDEA, Eclipse).
4. Atau gunakan command Maven:

```bash
mvn clean test

Penggunaan Tags

Untuk menjalankan semua test dengan tag @Login atau @checkout:

tags = "@Login or @checkout"


Untuk menjalankan test dengan kedua tag sekaligus:

tags = "@Login and @checkout"

Report

Setelah running test, report akan tersedia di folder target:

HTML report: target/cucumber-report.html

JSON report: target/cucumber.json

Catatan Penting

Pastikan locator yang digunakan sesuai dengan versi aplikasi.

Jika element tidak visible di layar, gunakan metode scroll sebelum mencari element.

Gunakan toleransi floating point untuk verifikasi harga dengan format $5.99.

Pastikan semua step definition dan feature file sinkron.

Kontak

Jika ada pertanyaan atau butuh bantuan, silakan hubungi Muhammad Rifqi.