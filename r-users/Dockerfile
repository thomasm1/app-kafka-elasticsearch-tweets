FROM node:alpine
WORKDIR /app
COPY package.json ./
CMD npm install
COPY ./ ./
ENTRYPOINT ["npm","start"]

