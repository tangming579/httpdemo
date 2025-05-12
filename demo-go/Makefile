HARBOR_URL= registry-dev.idc.com/system_containers
BUILDER_IMG = ${HARBOR_URL}/golang:alpine3.21
BASE_IMG = ${HARBOR_URL}/alpine:3.21
ARTIFACT_NAME = httpdemo
VERSION = v1.0

build:
	mkdir -p binary/
	CGO_ENABLED=0 GOOS=linux go build -ldflags "-extldflags -static -w -s" -o binary/${ARTIFACT_NAME} -v main.go

image:
	IMG_TAG=$(HARBOR_URL)/$(ARTIFACT_NAME):$(VERSION)-amd64-$(shell date +"%Y%m%d%H%M%S%3N" | head -c 14) && \
    docker buildx build --load --platform linux/amd64 \
    --build-arg BASE_IMAGE=$(BASE_IMG) \
    --build-arg BUILDER_IMAGE=$(BUILDER_IMG) \
    -t $$IMG_TAG .

image-arm64:
	IMG_TAG=$(HARBOR_URL)/$(ARTIFACT_NAME):$(VERSION)-amd64-$(shell date +"%Y%m%d%H%M%S%3N" | head -c 14) && \
    docker buildx build --load --platform linux/arm64 \
    --build-arg BASE_IMAGE=$(BASE_IMG) \
    --build-arg BUILDER_IMAGE=$(BUILDER_IMG) \
    -t $$IMG_TAG .