ARG BASE_IMAGE=alpine:3.21
ARG TARGETARCH=arm64

FROM --platform=${TARGETPLATFORM} ${BASE_IMAGE}
RUN apk update && apk add --no-cache iputils curl telnet

COPY ./binary/demo /demo

ENTRYPOINT ["/demo"]