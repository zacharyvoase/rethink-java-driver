package com.rethinkdb.ast.query.gen;

import com.rethinkdb.RethinkDBConnection;
import com.rethinkdb.ast.query.RqlQuery;
import com.rethinkdb.proto.Q2L;
import com.rethinkdb.response.DBResponseMapper;
import com.rethinkdb.response.model.DMLResult;

import java.util.List;
import java.util.Map;

// extends RqlMethodQuery
public class Replace extends RqlQuery {

    public Replace(List<Object> args, java.util.Map<String, Object> optionalArgs) {
        this(null, args, optionalArgs);
    }

    public Replace(RqlQuery prev, List<Object> args, Map<String, Object> optionalArgs) {
        super(prev, Q2L.Term.TermType.REPLACE, args, optionalArgs);
    }

    @Override
    public DMLResult run(RethinkDBConnection connection) {
        return DBResponseMapper.populateObject(new DMLResult(), (Map<String, Object>) super.run(connection));
    }
}
        