FROM node:alpine
COPY package.json /app/package.json
CMD npm install
COPY ./ ./
ENTRYPOINT ["npm","start"]

