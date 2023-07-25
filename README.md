# hello-openshift-02-ftp

This service demos Apache Camel Quarkus Extensions, ftp and Kafka in particular.

The service picks up a file from an ftp server, splits it, and puts the resulting messages onto a Kafka topic.

## Running Locally

You will need to start an FTP server.  bogem/ftp is a container that will work.  

It can be started with the following command:

```shell
docker run -d -v /Users/USERNAME/Desktop/ftp_source:/home/vsftpd \
    -p 20:20 -p 21:21 -p 47400-47470:47400-47470 \
    -e FTP_USER=ftpuser \
    -e FTP_PASS=ftppass \
    -e PASV_ADDRESS=127.0.0.1 \
    --name ftp \
    --restart=always bogem/ftp
```

Create a file with one greeting per line and drop it in your "ftp_source" folder.

To retrieve the file:

```shell
ftp ftpuser@localhost

Connected to localhost.
220 (vsFTPd 3.0.3)
331 Please specify the password.
Password:

'ftppass'

ftp> pass
ftp> cd uploads
ftp> get file.txt
ftp> bye

cat file.txt
```

