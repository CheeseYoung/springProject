package com.princess.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = -345465644L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard board = new QBoard("board");

    public final EnumPath<CheckCondition.CmCategory> cmCategory = createEnum("cmCategory", CheckCondition.CmCategory.class);

    public final StringPath content = createString("content");

    public final EnumPath<CheckCondition.Display> display = createEnum("display", CheckCondition.Display.class);

    public final NumberPath<Long> great = createNumber("great", Long.class);

    public final StringPath photoPath = createString("photoPath");

    public final NumberPath<Long> postNum = createNumber("postNum", Long.class);

    public final DatePath<java.util.Date> regdate = createDate("regdate", java.util.Date.class);

    public final ListPath<Reply, QReply> replyList = this.<Reply, QReply>createList("replyList", Reply.class, QReply.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final QMember userId;

    public QBoard(String variable) {
        this(Board.class, forVariable(variable), INITS);
    }

    public QBoard(Path<? extends Board> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard(PathMetadata metadata, PathInits inits) {
        this(Board.class, metadata, inits);
    }

    public QBoard(Class<? extends Board> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userId = inits.isInitialized("userId") ? new QMember(forProperty("userId")) : null;
    }

}

