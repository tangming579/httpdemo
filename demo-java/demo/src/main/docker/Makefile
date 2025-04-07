VERSION = v1.0
AMD64_IMG = registry-dev.indc.vnet.com/system_containers/openjdk:17.0.2-oracle
ARM64_IMG = registry-dev.indc.vnet.com/arm64/openjdk:17.0-jdk-oracle
ARTIFACT_NAME = demo-java
HARBOR_URL = registry-dev.indc.vnet.com

build-amd64:
	IMG_TAG=$(HARBOR_URL)/system_containers/$(ARTIFACT_NAME):$(VERSION)-amd64-$(shell date +"%Y%m%d%H%M%S%3N" | head -c 14) && \
    docker buildx build . --load --platform linux/amd64 --build-arg BASE_IMAGE=$(AMD64_IMG) -t $$IMG_TAG

build-arm64:
	IMG_TAG=$(HARBOR_URL)/system_containers/$(ARTIFACT_NAME):$(VERSION)-arm64-$(shell date +"%Y%m%d%H%M%S%3N" | head -c 14) && \
    docker buildx build . --load --platform linux/arm64 --build-arg BASE_IMAGE=$(ARM64_IMG) -t $$IMG_TAG

build-all: build-amd64 build-arm64
