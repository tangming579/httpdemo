package main

import (
	"github.com/gin-gonic/gin"
	"net/http"
	"strconv"
	"time"
)

func main() {
	r := gin.Default()

	r.GET("/hi", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{
			"msg": "ok",
		})
	})

	r.GET("/hi/:delay", func(c *gin.Context) {
		delayParam := c.Param("delay")
		if delayParam != "" { // 存在 delay 参数时才处理
			delay, err := strconv.Atoi(delayParam)
			if err != nil || delay < 0 { // 校验合法性
				c.JSON(http.StatusOK, gin.H{
					"msg": "ok",
				})
				return
			}
			time.Sleep(time.Duration(delay) * time.Millisecond) // 应用延时
		}

		c.JSON(http.StatusOK, gin.H{
			"msg": "ok",
		})
	})

	r.Run(":8080")
}
