/*
 * Copyright 2014 websudos ltd.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.websudos.reactiveneo.dsl

import org.scalatest.{Matchers, FlatSpec}

class AttributeReturnExpressionTest extends FlatSpec with Matchers {

  it should "serialize to valid return statement" in {
    val node = new TestNode
    val context = new QueryBuilderContext
    context.register(node, "abc")
    AttributeReturnExpression(node.name).query(context).queryString shouldEqual "abc.name"
  }


  it should "convert to return expression" in {
    val node = new TestNode
    val context = new QueryBuilderContext
    context.register(node, "abc")
    (node.name:AttributeReturnExpression[TestNode, TestNodeRecord, String]).query(context).queryString shouldEqual "abc.name"
  }

}
