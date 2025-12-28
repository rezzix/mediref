# mediref
mediref is a set of referential data related to medical field, it's a utility project used to publish some webservices to keep medical referential data in a memory cache ready to be searched and served.

## technical stack
The project uses springboot for the restful webservices, and elastic search for the cache.
The user request can search using any part of the data and elastic search will give a list of results using fulltext search.

## howto
Elastic search will synchronize the data from a relational database into memory earch 5 minutes, the application will accept web requests with search criteria, its will answer with a json list from elastic search.

## dev environment
In the dev environment we will use dockerised images 
### elastic search 
docker run -d --name elastic-search -p 9200:9200 -v c:\docker\elastic-search\data:/usr/share/elasticsearch/data -e "discovery.type=single-node" -e "xpack.security.enabled=false" -e "ES_JAVA_OPTS=-Xms1g -Xmx1g" docker.elastic.co/elasticsearch/elasticsearch:8.15.0
### elastic search 
docker run --hostname=388ff7a701de --mac-address=a6:9c:12:61:47:b0 --env=POSTGRES_PASSWORD=postgres --env=PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/postgresql/18/bin --env=GOSU_VERSION=1.19 --env=LANG=en_US.utf8 --env=PG_MAJOR=18 --env=PG_VERSION=18.0-1.pgdg13+3 --env=PGDATA=/var/lib/postgresql/18/docker --volume=C:\docker\postgres:/var/lib/postgresql --volume=/var/lib/postgresql --network=bridge -p 5432:5432 --restart=no --runtime=runc -d postgres:latest

## data
Example data is given by WHO's ICD-11 data, a data base table with the following structure : 
CREATE TABLE public.diagnostic_reference (
	id int8 NOT NULL,
	"level" int4 NULL,
	id4 int8 NULL,
	code varchar(50) NULL,
	id3 int8 NULL,
	diagnostic varchar(500) NOT NULL,
	id5 int8 NULL,
	id7 int8 NULL,
	diagnostic_lower varchar(500) NULL,
	id1 int8 NULL,
	id2 int8 NULL,
	ordre varchar(255) NULL,
	"type" varchar(10) NULL,
	id6 int8 NULL,
	code_lower varchar(50) NULL,
	CONSTRAINT diagnostic_reference_pkey PRIMARY KEY (id)
);

This is an example of the data that can be found in it :
INSERT INTO public.diagnostic_reference (id,"level",id4,code,id3,diagnostic,id5,id7,diagnostic_lower,id1,id2,ordre,"type",id6,code_lower) VALUES
	 (1,1,0,'(A00-B99)',0,'certaines maladies infectieuses et parasitaires',0,0,'certaines maladies infectieuses et parasitaires',1,0,'A00''','C',0,'(a00-b99)'),
	 (2,2,0,'(A00-A09)',0,'maladies intestinales infectieuses',0,0,'maladies intestinales infectieuses',1,2,'A00-','G',0,'(a00-a09)'),
	 (3,3,0,'A00',3,'choléra',0,0,'choléra',1,2,'A00,','K',0,'a00'),
	 (4,4,4,'A00.0',3,'à Vibrio cholerae 01, biovar cholerae',0,0,'à vibrio cholerae 01, biovar cholerae',1,2,'A00.0','S',0,'a00.0'),
	 (5,4,5,'A00.1',3,'à Vibrio cholerae 01, biovar El Tor',0,0,'à vibrio cholerae 01, biovar el tor',1,2,'A00.1','S',0,'a00.1'),
	 (6,4,6,'A00.9',3,'choléra, sans précision',0,0,'choléra, sans précision',1,2,'A00.9','S',0,'a00.9'),
	 (7,3,0,'A01',7,'fièvres typhoïde et paratyphoïde',0,0,'fièvres typhoïde et paratyphoïde',1,2,'A01','K',0,'a01'),
	 (8,4,8,'A01.0',7,'fièvre typhoïde',0,0,'fièvre typhoïde',1,2,'A01.0','S',0,'a01.0'),
	 (9,4,9,'A01.1',7,'paratyphoïde A',0,0,'paratyphoïde a',1,2,'A01.1','S',0,'a01.1'),
	 (10,4,10,'A01.2',7,'paratyphoïde B',0,0,'paratyphoïde b',1,2,'A01.2','S',0,'a01.2');
