
#!/bin/bash
docker build . --tag thomasm1/client-mapl-dashboard:2.2.2  && \
docker run -it dashboard --port 8888:8888  \


