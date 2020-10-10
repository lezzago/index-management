package com.amazon.opendistroforelasticsearch.indexmanagement.indexstatemanagement.transport.action.getpolicies

import com.amazon.opendistroforelasticsearch.indexmanagement.indexstatemanagement.model.Table
import org.elasticsearch.action.ActionRequest
import org.elasticsearch.action.ActionRequestValidationException
import org.elasticsearch.common.io.stream.StreamInput
import org.elasticsearch.common.io.stream.StreamOutput
import java.io.IOException

class GetPoliciesRequest : ActionRequest {

    val table: Table

    constructor(
        table: Table

    ) : super() {
        this.table = table
    }

    @Throws(IOException::class)
    constructor(sin: StreamInput) : this(
        table = Table.readFrom(sin)
    )

    override fun validate(): ActionRequestValidationException? {
        return null
    }

    @Throws(IOException::class)
    override fun writeTo(out: StreamOutput) {
        table.writeTo(out)
    }
}
