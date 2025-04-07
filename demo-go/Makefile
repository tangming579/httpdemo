HARBOR_URL= registry-dev.indc.vnet.com
AMD64_IMG = alpine:3.21-amd64
ARM64_IMG = alpine:3.21-arm64
ARTIFACT_NAME = demo
VERSION = v1.0

build:
	mkdir -p binary/
	CGO_ENABLED=0 GOOS=linux go build -ldflags "-extldflags -static -w -s" -o binary/${ARTIFACT_NAME} -v main.go

image:
	IMG_TAG=$(HARBOR_URL)/system_containers/$(ARTIFACT_NAME):$(VERSION)-amd64-$(shell date +"%Y%m%d%H%M%S%3N" | head -c 14) && \
    docker buildx build --load --platform linux/amd64 \
    --build-arg BASE_IMAGE=$(AMD64_IMG) \
    --build-arg BASE_IMAGE=$(AMD64_IMG) \
    -t $$IMG_TAG .

image-arm64:
	IMG_TAG=$(HARBOR_URL)/system_containers/$(ARTIFACT_NAME):$(VERSION)-amd64-$(shell date +"%Y%m%d%H%M%S%3N" | head -c 14) && \
    docker buildx build --load --platform linux/arm64 \
    --build-arg BASE_IMAGE=$(AMD64_IMG) \
    --build-arg BASE_IMAGE=$(AMD64_IMG) \
    -t $$IMG_TAG .