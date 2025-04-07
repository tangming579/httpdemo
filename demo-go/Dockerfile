ARG BASE_IMAGE=alpine:3.21
ARG TARGETARCH=arm64

FROM --platform=${TARGETPLATFORM} ${BASE_IMAGE}

COPY ./binary/demo /demo

ENTRYPOINT ["/demo"]