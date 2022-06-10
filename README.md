# alami-coding-project

## Asumsi
1. Data di tiap kolom pada tiap baris valid
2. Semua data unik
3. Task 1, 2, 3 dikerjakan secara berurutan, tetapi eksekusi tiap baris dilakukan secara paralel
4. Jumlah thread yang digunakan adalah 8 untuk semua task (sesuai dengan no 3 pada soal)
5. Urutan yang dimaksud pada no 3 berdasarkan pada id di file Before Eod.csv

## Cara Menjalankan Program
1. Pastikan anda telah berada di dalam repository
2. Pastikan JDK yang digunakan >= 8
3. Pastikan Gradle yang digunakan > 4.9

### Unit Test
``./gradlew test``

### Program Utama
``./gradlew run --args="'Absolute/Path/Before Eod.csv' 'Absolute/Path/After Eod.csv'"``
