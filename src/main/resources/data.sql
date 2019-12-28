INSERT INTO link (id, created_by, creation_date, last_modified_by, last_modified_date,title, url) VALUES (1, null, now(), null, now(), "titulo1", "url1");
INSERT INTO comment (id, created_by, creation_date, last_modified_by,last_modified_date, body, link_id) VALUES (1, null,now(), null,now(), "body1", 1);

