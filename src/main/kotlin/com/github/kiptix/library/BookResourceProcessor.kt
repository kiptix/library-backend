package com.github.kiptix.library

import org.springframework.hateoas.Link
import org.springframework.hateoas.Resource
import org.springframework.hateoas.ResourceProcessor
import org.springframework.stereotype.Component

@Component
class BookResourceProcessor : ResourceProcessor<Resource<Book>> {

    override fun process(resource: Resource<Book>): Resource<Book> {
        val selfUrl = resource.getLink("self").href
        if (resource.content.user == null) {
            resource.add(Link(selfUrl + "/borrow", "borrow"))
        } else {
            resource.add(Link(selfUrl + "/return", "return"))
        }
        return resource
    }
}


