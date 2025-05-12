ARG BASE_IMAGE
ARG BUILDER_IMAGE

FROM --platform=${BUILDPLATFORM} ${BUILDER_IMAGE} as builder
COPY . /src
WORKDIR /src
RUN go env -w GOPROXY=https://goproxy.cn,direct
RUN go env -w GO111MODULE=on
RUN mkdir /binary && CGO_ENABLED=0 GOOS=linux go build -ldflags "-extldflags -static -w -s" -o /binary/demo -v main.go

FROM --platform=${TARGETPLATFORM} ${BASE_IMAGE}
COPY --from=builder /binary/demo /demo

ENTRYPOINT ["/demo"]