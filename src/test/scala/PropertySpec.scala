package test

import com.scalypher.Property

import org.scalatest._

class PropertySpec extends WordSpec with Matchers {

  "given a string" must {

    val key = "key"

    "serialize" in {
      Property(key, "asdf").toQuery shouldBe s"""$key:"asdf""""
    }

    "escape quotes" in {
      val string = """asdf"asdf"asdf"""
      val escaped = """asdf\"asdf\"asdf"""
      Property(key, string).toQuery shouldBe s"""$key:"$escaped""""
    }

  }

}