CRUD With DB
Bu proje, bir veritabanı ile basit bir CRUD (Create, Read, Update, Delete) uygulamasıdır. Java Spring Boot kullanılarak geliştirilmiştir ve temel iletişim bilgilerini yönetmek için bir uygulama sağlar.

Özellikler
Kişi Listesi Görüntüleme: Kişilerin listesini görüntüleyebilirsiniz.
Yeni Kişi Ekleme: Yeni bir kişi ekleyebilirsiniz.
Kişi Düzenleme: Mevcut bir kişiyi düzenleyebilirsiniz.
Kişi Silme: Mevcut bir kişiyi silebilirsiniz.
Arama: Kişi listesinde arama yapabilirsiniz.
Teknolojiler
Java 11+
Spring Boot 2.7+
Spring Data JPA
H2 Database (veya başka bir ilişkisel veritabanı)
Gereksinimler
Java JDK 11 veya daha yeni bir sürüm
Maven (veya Gradle) - proje bağımlılıkları için
Kurulum

Projeyi Klonlayın:
git clone https://github.com/potuu/crud-with-db.git

Proje Dizini İçine Girin:
cd crud-with-db


Bağımlılıkları Yükleyin:
Maven kullanıyorsanız:
mvn install

Gradle kullanıyorsanız:
gradle build


Uygulamayı Başlatın:
Maven kullanıyorsanız:
mvn spring-boot:run

Gradle kullanıyorsanız:
gradle bootRun

Web Tarayıcınızı Açın:
Tarayıcınızda şu URL'yi ziyaret edin:
http://localhost:8080


Kullanım
Ana Sayfa: Tüm kişilerin listesini görüntüleyebilir ve arama yapabilirsiniz.
Yeni Kişi Ekleme: /new URL'sine giderek yeni bir kişi ekleyebilirsiniz.
Kişi Düzenleme: Bir kişiyi düzenlemek için kişinin ID'sini içeren /edit/{id} URL'sine gidin.
Kişi Silme: Bir kişiyi silmek için kişinin ID'sini içeren /delete/{id} URL'sine POST isteği gönderin.
API Endpoints
GET /: Ana sayfa - Kişi listesini görüntüler
GET /new: Yeni kişi ekleme formunu görüntüler
POST /new: Yeni kişiyi ekler
GET /edit/{id}: Belirli bir kişiyi düzenleme formunu görüntüler
POST /edit/{id}: Belirli kişiyi günceller
POST /delete/{id}: Belirli kişiyi siler
Veritabanı
Varsayılan olarak, uygulama H2 veritabanını kullanır. H2 veritabanını yönetmek ve tarayıcı üzerinden veritabanınızı görüntülemek için aşağıdaki URL'yi kullanabilirsiniz:

bash
Kodu kopyala
http://localhost:8080/h2-console
Bu URL'yi kullanarak H2 konsoluna erişebilir ve veritabanınızı sorgulayabilirsiniz. Varsayılan JDBC URL'si jdbc:h2:mem:testdb'dir.
