FROM node:alpine

WORKDIR /app
COPY package.json ./
RUN npm install
RUN npm run build

CMD ["serve","-s","build"]

